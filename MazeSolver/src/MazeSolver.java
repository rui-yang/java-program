import java.util.LinkedList;

public class MazeSolver {
    //0 = wall
    //1 = path
    //2 = destination
    static int[][] maze = {
            {2, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 1, 0}
    };

    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] arg) {
        Position p = new Position(0, 3);
        path.push(p);

        int i = 0;
        while(true) {
            int y = path.peek().y;
            int x = path.peek().x;

            maze[y][x] = 0;

            //down
            System.out.println("Check down at (" + y + " " + x + ")");
            i++;
            if(isValid(y+1, x)) {
                System.out.println("Check down.");
                if(maze[y+1][x] == 2) {
                    System.out.println("Moved down. You won!");
                    System.out.println("total checks: " + i);
                    return;
                } else if (maze[y+1][x] == 1) {
                    System.out.println("Moved down!");
                    path.push(new Position(y+1, x));
                    continue;
                }
            }


            //left
            System.out.println("Check left at (" + y + " " + x + ")");
            i++;
            if(isValid(y, x-1)) {
                System.out.println("Check left.");
                if(maze[y][x-1] == 2) {
                    System.out.println("Moved left. You won!");
                    System.out.println("total checks: " + i);
                    return;
                } else if (maze[y][x-1] == 1) {
                    System.out.println("Moved left!");
                    path.push(new Position(y, x-1));
                    continue;
                }
            }

            //up
            System.out.println("Check up at (" + y + " " + x + ")");
            i++;
            if(isValid(y-1, x)) {
                if(maze[y-1][x] == 2) {
                    System.out.println("Moved up. You won!");
                    System.out.println("total checks: " + i);
                    return;
                } else if (maze[y-1][x] == 1) {
                    System.out.println("Moved up!");
                    path.push(new Position(y-1, x));
                    continue;
                }
            }

            //right
            if(isValid(y, x+1)) {
                if(maze[y][x+1] == 2) {
                    System.out.println("Moved right. You won!");
                    System.out.println("total checks: " + i);
                    return;
                } else if (maze[y][x+1] == 1) {
                    System.out.println("Moved right!");
                    path.push(new Position(y, x+1));
                    continue;
                }
            }

            path.pop();
            System.out.println("Moved back.");
            if(path.size() <= 0) {
                System.out.println("No path.");
                return;
            }
        }
    }

    public static boolean isValid(int y, int x) {
        if(y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
            return false;
        }
        return true;
    }
}
