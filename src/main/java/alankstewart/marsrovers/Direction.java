package alankstewart.marsrovers;

/**
 * Created by alanstewart on 28/11/2015.
 */
public enum Direction {

    N(0, 1) {
        @Override
        public Direction left() {
            return W;
        }

        @Override
        public Direction right() {
            return E;
        }
    },
    S(0, -1) {
        @Override
        public Direction left() {
            return E;
        }

        @Override
        public Direction right() {
            return W;
        }
    },
    E(1, 0) {
        @Override
        public Direction left() {
            return N;
        }

        @Override
        public Direction right() {
            return S;
        }
    },
    W(-1, 0) {
        @Override
        public Direction left() {
            return S;
        }

        @Override
        public Direction right() {
            return N;
        }
    };

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract Direction left();

    public abstract Direction right();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
