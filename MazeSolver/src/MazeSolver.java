import java.util.LinkedList;

public class MazeSolver {
    //0 = wall
    //1 = path
    //2 = destination
    static int[][] maze = {
            {2, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 0, 1, 0}
    };

    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] arg) {
        Position p = new Position(3, 0);
        path.push(p);

        maze[path.peek().y][path.peek().x] = 0;
    }

}
