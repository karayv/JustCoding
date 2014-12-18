package my.coding.nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class TreeWalking {

    private Comparator<Path> pathDescCmp = (p1, p2) -> p2.getFileName().toString()
            .compareTo(p1.getFileName().toString());
    
    private Stream<Path> firstAlphaOrdered(Path path, int numberOfFiles) throws IOException {
        PriorityQueue<Path> queue = new PriorityQueue<>(pathDescCmp);
        
        Files.walkFileTree(path, new SortingFileVisitor(numberOfFiles, queue));
        
        return queue.stream();
    }

    private class SortingFileVisitor extends SimpleFileVisitor<Path> {
        
        private int numberOfFiles;
        private PriorityQueue<Path> queue;

        public SortingFileVisitor(int numberOfFiles, PriorityQueue<Path> queue) {
            this.numberOfFiles = numberOfFiles;
            this.queue = queue;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            queue.offer(file);
            
            if (queue.size() > numberOfFiles) {
                queue.poll();
            }
            
            return FileVisitResult.CONTINUE;
        }
    }
    
    public static void main(String[] args) throws IOException {
        String dirStr = args.length == 0 ? "." : args[0];
        Path path = Paths.get(dirStr);
        
        System.out.println("Walking file tree " + path.toAbsolutePath()
                + " finding top 5 alphabetically ordered file names.\n");
        
        Stream<Path> top5 = new TreeWalking()
            .firstAlphaOrdered(path, 5);
        
        top5.map(p -> p.getFileName().toString()).forEach(System.out::println);
    }

}
