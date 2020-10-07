import java.util.LinkedList;

public class MazeSolver {
    static Maze m = new Maze();

    public static void main(String[] arg) {
        //0 = wall
        //1 = path
        //2 = destination
        int[][] maze = {
                {2, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        };

        m.maze = maze;
        m.path = new LinkedList<Position>();

        if(solveMaze(new Position(0, 3))) {
            System.out.println("You won!");
        } else {
            System.out.println("No path.");
        }
    }

    private static boolean solveMaze(Position p) {
        m.path.push(p);

        int i = 0;
        while(true) {
            int y = m.path.peek().y;
            int x = m.path.peek().x;

            m.maze[y][x] = 0;

            //down
            if(isValid(y+1, x)) {
                if(m.maze[y+1][x] == 2) {
                    return true;
                } else if (m.maze[y+1][x] == 1) {
                    System.out.println("Moved down!");
                    m.path.push(new Position(y+1, x));
                    continue;
                }
            }

            //left
            if(isValid(y, x-1)) {
                if(m.maze[y][x-1] == 2) {
                    return true;
                } else if (m.maze[y][x-1] == 1) {
                    System.out.println("Moved left!");
                    m.path.push(new Position(y, x-1));
                    continue;
                }
            }

            //up
            if(isValid(y-1, x)) {
                if(m.maze[y-1][x] == 2) {
                    return true;
                } else if (m.maze[y-1][x] == 1) {
                    System.out.println("Moved up!");
                    m.path.push(new Position(y-1, x));
                    continue;
                }
            }

            //right
            if(isValid(y, x+1)) {
                if(m.maze[y][x+1] == 2) {
                    return true;
                } else if (m.maze[y][x+1] == 1) {
                    System.out.println("Moved right!");
                    m.path.push(new Position(y, x+1));
                    continue;
                }
            }

            m.path.pop();
            System.out.println("Moved back.");
            if(m.path.size() <= 0) {
                return false;
            }
        }
    }

    public static boolean isValid(int y, int x) {
        if(y < 0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length) {
            return false;
        }
        return true;
    }
}
