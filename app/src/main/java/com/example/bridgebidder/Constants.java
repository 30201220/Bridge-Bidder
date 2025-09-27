package com.example.bridgebidder;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static class Position {
        public static final int north = 0;
        public static final int east = 1;
        public static final int south = 2;
        public static final int west = 3;
    }

    public static class Bid {
        public static final int b_1C = 11;
        public static final int b_1D = 12;
        public static final int b_1H = 13;
        public static final int b_1S = 14;
        public static final int b_1N = 15;
        public static final int b_2C = 21;
        public static final int b_2D = 22;
        public static final int b_2H = 23;
        public static final int b_2S = 24;
        public static final int b_2N = 25;
        public static final int b_3C = 31;
        public static final int b_3D = 32;
        public static final int b_3H = 33;
        public static final int b_3S = 34;
        public static final int b_3N = 35;
        public static final int b_4C = 41;
        public static final int b_4D = 42;
        public static final int b_4H = 43;
        public static final int b_4S = 44;
        public static final int b_4N = 45;
        public static final int b_5C = 51;
        public static final int b_5D = 52;
        public static final int b_5H = 53;
        public static final int b_5S = 54;
        public static final int b_5N = 55;
        public static final int b_6C = 61;
        public static final int b_6D = 62;
        public static final int b_6H = 63;
        public static final int b_6S = 64;
        public static final int b_6N = 65;
        public static final int b_7C = 71;
        public static final int b_7D = 72;
        public static final int b_7H = 73;
        public static final int b_7S = 74;
        public static final int b_7N = 75;
        public static final int b_P = 1;
        public static final int b_X = 81;
        public static final int b_XX = 91;
    }

    public static HashMap<Integer, String> bidMap = new HashMap<>();
    public static <T, E> Integer getKeyByValue(E value) {
        for (Map.Entry<Integer, String> entry : bidMap.entrySet()) {
            if (value == entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }
    static {
        bidMap.put(0, "");
        bidMap.put(Bid.b_1C, "1C");
        bidMap.put(Bid.b_1D, "1D");
        bidMap.put(Bid.b_1H, "1H");
        bidMap.put(Bid.b_1S, "1S");
        bidMap.put(Bid.b_1N, "1N");
        bidMap.put(Bid.b_2C, "2C");
        bidMap.put(Bid.b_2D, "2D");
        bidMap.put(Bid.b_2H, "2H");
        bidMap.put(Bid.b_2S, "2S");
        bidMap.put(Bid.b_2N, "2N");
        bidMap.put(Bid.b_3C, "3C");
        bidMap.put(Bid.b_3D, "3D");
        bidMap.put(Bid.b_3H, "3H");
        bidMap.put(Bid.b_3S, "3S");
        bidMap.put(Bid.b_3N, "3N");
        bidMap.put(Bid.b_4C, "4C");
        bidMap.put(Bid.b_4D, "4D");
        bidMap.put(Bid.b_4H, "4H");
        bidMap.put(Bid.b_4S, "4S");
        bidMap.put(Bid.b_4N, "4N");
        bidMap.put(Bid.b_5C, "5C");
        bidMap.put(Bid.b_5D, "5D");
        bidMap.put(Bid.b_5H, "5H");
        bidMap.put(Bid.b_5S, "5S");
        bidMap.put(Bid.b_5N, "5N");
        bidMap.put(Bid.b_6C, "6C");
        bidMap.put(Bid.b_6D, "6D");
        bidMap.put(Bid.b_6H, "6H");
        bidMap.put(Bid.b_6S, "6S");
        bidMap.put(Bid.b_6N, "6N");
        bidMap.put(Bid.b_7C, "7C");
        bidMap.put(Bid.b_7D, "7D");
        bidMap.put(Bid.b_7H, "7H");
        bidMap.put(Bid.b_7S, "7S");
        bidMap.put(Bid.b_7N, "7N");
        bidMap.put(Bid.b_P, "P ");
        bidMap.put(Bid.b_X, "X ");
        bidMap.put(Bid.b_XX, "XX");
    }


    public static final int [] valueTable = {
            0,
            0, 1, 2, 3,
            1, 2, 3, 0,
            2, 3, 0, 1,
            3, 0, 1, 2,
            0, 1, 2, 3,
            1, 2, 3, 0,
            2, 3, 0, 1,
            3, 0, 1, 2,
            0, 1, 2, 3,
            1, 2, 3, 0,
            2, 3, 0, 1,
            3, 0, 1, 2
    };

    public static final int [] dealerTable = {
            0,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west,
            Position.north, Position.east, Position.south, Position.west
    };
    public static final Board [] boards = {
            new Board(0),
            new Board(1),
            new Board(2),
            new Board(3),
            new Board(4),
            new Board(5),
            new Board(6),
            new Board(7),
            new Board(8),
            new Board(9),
            new Board(10),
            new Board(11),
            new Board(12),
            new Board(13),
            new Board(14),
            new Board(15),
            new Board(16),
            new Board(17),
            new Board(18),
            new Board(19),
            new Board(20),
            new Board(21),
            new Board(22),
            new Board(23),
            new Board(24),
            new Board(25),
            new Board(26),
            new Board(27),
            new Board(28),
            new Board(29),
            new Board(30),
            new Board(31),
            new Board(32),
            new Board(33),
            new Board(34),
            new Board(35),
            new Board(36),
            new Board(37),
            new Board(38),
            new Board(39),
            new Board(40),
            new Board(41),
            new Board(42),
            new Board(43),
            new Board(44),
            new Board(45),
            new Board(46),
            new Board(47),
            new Board(48),
    };
}
