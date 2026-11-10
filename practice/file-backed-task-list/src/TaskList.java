// File-backed Task List. Reference exercise added during portfolio preparation.
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

/** A local text-file task list. Run from its project folder. */
public final class TaskList {
    private static final class Task {
        final int id; final String title; boolean done;
        Task(int id, boolean done, String title) {this.id=id;this.done=done;this.title=title;}
    }
    private final List<Task> tasks=new ArrayList<>();
    private final Path file;
    private long nextId=1;
    private TaskList(Path file){this.file=file;}
    private void load() throws IOException {
        if(!Files.exists(file)) return;
        Set<Integer> seen=new HashSet<>();
        int lineNumber=0;
        for(String line:Files.readAllLines(file,StandardCharsets.UTF_8)){
            lineNumber++;
            if(line.trim().isEmpty()||line.startsWith("#"))continue;
            String[] parts=line.split("\t",3);
            try{
                if(parts.length!=3)throw new IllegalArgumentException();
                int id=Integer.parseInt(parts[0]);
                if(id<1||!seen.add(id)||(!parts[1].equals("OPEN")&&!parts[1].equals("DONE"))||parts[2].trim().isEmpty()||parts[2].contains("\t"))throw new IllegalArgumentException();
                tasks.add(new Task(id,parts[1].equals("DONE"),parts[2]));
                nextId=Math.max(nextId,(long)id+1);
            }catch(IllegalArgumentException e){throw new IOException("Invalid record on line "+lineNumber+". Original file has not been changed.");}
        }
    }
    private void save() throws IOException {
        Path absolute=file.toAbsolutePath();
        Path parent=absolute.getParent();
        Files.createDirectories(parent);
        Path temporary=Files.createTempFile(parent,"task-list-",".tmp");
        List<String> lines=new ArrayList<>();
        lines.add("# Task list: id<TAB>OPEN or DONE<TAB>title");
        for(Task t:tasks)lines.add(t.id+"\t"+(t.done?"DONE":"OPEN")+"\t"+t.title);
        try{
            Files.write(temporary,lines,StandardCharsets.UTF_8);
            try{Files.move(temporary,absolute,StandardCopyOption.ATOMIC_MOVE,StandardCopyOption.REPLACE_EXISTING);}
            catch(AtomicMoveNotSupportedException e){Files.move(temporary,absolute,StandardCopyOption.REPLACE_EXISTING);}
        }finally{Files.deleteIfExists(temporary);}
    }
    private Task find(int id){for(Task t:tasks)if(t.id==id)return t;return null;}
    private void process(String command) throws IOException {
        String[] parts=command.trim().split("\\s+",2);
        String action=parts[0].toLowerCase(Locale.ROOT);
        if(action.equals("list")){
            if(tasks.isEmpty())System.out.println("No tasks.");
            for(Task t:tasks)System.out.println(t.id+" ["+(t.done?"done":"open")+"] "+t.title);
        }else if(action.equals("add")){
            if(parts.length<2||parts[1].trim().isEmpty()||parts[1].contains("\t")){System.out.println("Use: add a title without tabs");return;}
            if(nextId>Integer.MAX_VALUE){System.out.println("Task ID limit reached.");return;}
            Task task=new Task((int)nextId,false,parts[1].trim());tasks.add(task);
            try{save();nextId++;}catch(IOException e){tasks.remove(task);throw e;}
            System.out.println("Added task "+task.id+".");
        }else if(action.equals("done")||action.equals("remove")){
            int id;
            try{id=parts.length==2?Integer.parseInt(parts[1].trim()):-1;}
            catch(NumberFormatException e){System.out.println("Use a positive integer ID.");return;}
            Task task=find(id);
            if(task==null){System.out.println("Task not found.");return;}
            boolean oldDone=task.done;int oldIndex=tasks.indexOf(task);
            if(action.equals("done"))task.done=true;else tasks.remove(task);
            try{save();}catch(IOException e){if(action.equals("done"))task.done=oldDone;else tasks.add(oldIndex,task);throw e;}
            System.out.println("Saved.");
        }else if(!action.isEmpty())System.out.println("Commands: list, add TITLE, done ID, remove ID, quit");
    }
    public static void main(String[] args){
        Path path;
        try{path=Paths.get(args.length==0?"tasks.tsv":args[0]);}
        catch(InvalidPathException e){System.err.println("Invalid task-file path: "+e.getReason());return;}
        TaskList app=new TaskList(path);
        try{app.load();}catch(IOException e){System.err.println(e.getMessage());return;}
        System.out.println("Local task list. Commands: list, add TITLE, done ID, remove ID, quit");
        try(Scanner scanner=new Scanner(System.in)){
            while(scanner.hasNextLine()){
                String command=scanner.nextLine();
                if(command.trim().equalsIgnoreCase("quit"))break;
                try{app.process(command);}catch(IOException e){System.err.println("Save failed: "+e.getMessage());}
            }
        }
    }
}
