package alankstewart.marsrovers;

import java.util.Arrays;

/**
 * Created by alanstewart on 28/11/2015.
 */
public enum Direction {

    North {
        @Override
        public Direction left() {
            return West;
        }

        @Override
        public Direction right() {
            return East;
        }

        @Override
        public String toString() {
            return "N";
        }
    },
    South {
        @Override
        public Direction left() {
            return East;
        }

        @Override
        public Direction right() {
            return West;
        }

        @Override
        public String toString() {
            return "S";
        }
    },
    East {
        @Override
        public Direction left() {
            return North;
        }

        @Override
        public Direction right() {
            return South;
        }

        @Override
        public String toString() {
            return "E";
        }
    },
    West {
        @Override
        public Direction left() {
            return South;
        }

        @Override
        public Direction right() {
            return North;
        }

        @Override
        public String toString() {
            return "W";
        }
    };

    public abstract Direction left();

    public abstract Direction right();

    public static Direction from(String symbol) {
        return Arrays.stream(values())
                .filter(d -> d.toString().equalsIgnoreCase(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown direction " + symbol));
    }
}
