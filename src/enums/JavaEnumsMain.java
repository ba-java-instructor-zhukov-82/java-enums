package enums;

import java.util.Arrays;
import java.util.Scanner;

public class JavaEnumsMain {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //enumValuesMethodTest();
        //enumOrdinalMethodTest();
        //enumNameMethodTest();
        //enumValueOfMethodTest();
        //enumLogicalComparingTest();
        //enumFieldsTest();
        //enumConstantsToStringOverrrding();
        //enumSwitchTest();
        enumInterfaceImplementationTest();

        /*----- Closing of scanner instance -----*/
        sc.close();
    }

    private static void enumValuesMethodTest() {
        System.out.println(Arrays.toString(DayEating.values()));
        System.out.println(DayEating.values()[1]); //DINNER
        System.out.println(DayEating.values()[0].toString().toLowerCase());
    }

    private static void enumOrdinalMethodTest() {
        System.out.format("Ordinal index of SUPPER is %d%n",
                          DayEating.SUPPER.ordinal());
        DayEating eatingTime = DayEating.DINNER;
        System.out.format("Ordinal index of DINNER is %d%n",
                          eatingTime.ordinal());
    }

    private static void enumNameMethodTest() {
        System.out.println(DayEating.BREAKFAST.name());
    }

    private static void enumValueOfMethodTest() {
        System.out.println(DayEating.valueOf(read()));
    }

    private static String read() {
        System.out.println("Please, enter some DayEating time Name:");
        String input = sc.nextLine().toUpperCase();
        return isDayEatingConstant(input) ? input : DayEating.BREAKFAST.name();
    }

    private static boolean isDayEatingConstant(String value) {
        for(DayEating dayEating : DayEating.values())
            if(dayEating.name().equals(value))
                return true;
        return false;
    }

    private static void enumLogicalComparingTest() {
        DayEating de1 = DayEating.BREAKFAST;
        DayEating de2 = DayEating.BREAKFAST;
        System.out.format("%d == %d is %s%n",
                          de1.hashCode(), de2.hashCode(),
                          de1.hashCode() == de2.hashCode());
    }

    private static void enumFieldsTest() {
        for(DayEating dayEating : DayEating.values())
            System.out.format("%s time: %s%n",
                              dayEating, dayEating.getTime());
        DayEating.BREAKFAST.setTime("07:00");
        System.out.println(DayEating.BREAKFAST.getTime());

        for(DayEating dayEating : DayEating.values())
            System.out.format("%s time: %s," +
                              " recommended calories: %d%n",
                              dayEating,
                              dayEating.getTime(),
                              dayEating.getRecommendedCalories());

        DayEating.BREAKFAST.setRecommendedCalories(300);
        System.out.println(DayEating.BREAKFAST.getRecommendedCalories());
    }

    private static void enumConstantsToStringOverrrding() {
        for(DayEating dayEating : DayEating.values())
            System.out.format("Name: %s%nTo string: %s%n%n",
                              dayEating.name(),
                              dayEating.toString());
    }

    private static void enumSwitchTest() {
        switch(DayEating.valueOf(read())) {
            case BREAKFAST: {
                System.out.println("Good morning! Have a nice breakfast!");
                break;
            }
            case DINNER: {
                System.out.println("Good day! Have a nice dinner!");
                break;
            }
            case SUPPER: {
                System.out.println("Good evening! Have a nice supper!");
                break;
            }
        }
    }

    private static void enumInterfaceImplementationTest() {
        for(Seasons season : Seasons.values())
            System.out.format(
                    "Name: %s%n" +
                    "first month: %s%n" +
                    "second month: %s%n" +
                    "third month: %s%n%n",
                    season.name(),
                    season.getFirst(),
                    season.getSecond(),
                    season.getThird());
        Seasons.WINTER.snowing();
    }

    /*----- DayEating enum -----*/
    private enum DayEating {
        BREAKFAST("06:00", 500) {
            @Override
            public String toString() {
                return "Morning eating time!";
            }
        },
        DINNER("12:00", 600) {
            @Override
            public String toString() {
                return "Day eating time!";
            }
        },
        SUPPER("18:00", 400) {
            @Override
            public String toString() {
                return "Evening eating time!";
            }
        };

        private String time;
        private int recommendedCalories;

        public void setTime(String time) {
            this.time = time;
        }

        public String getTime() {
            return time;
        }

        public int getRecommendedCalories() {
            return recommendedCalories;
        }

        public void setRecommendedCalories(int recommendedCalories) {
            this.recommendedCalories = recommendedCalories;
        }

        DayEating(String time, int recommendedCalories) {
            this.time = time;
            this.recommendedCalories = recommendedCalories;
        }
    }

    private interface Winter {
        final String DECEMBER = "DECEMBER";
        final String JANUARY = "JANUARY";
        final String FEBRUARY = "FEBRUARY";

        void snowing();
    }

    private enum Seasons implements Winter {
        WINTER(Winter.DECEMBER, Winter.JANUARY, Winter.FEBRUARY);

        private final String first;
        private final String second;
        private final String third;

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }

        public String getThird() {
            return third;
        }

        private Seasons(String first, String second, String third) {
            this.first = Winter.DECEMBER;
            this.second = Winter.JANUARY;
            this.third = Winter.FEBRUARY;
        }

        @Override
        public void snowing() {
            String[] winterWeather = {
                    "snowy", "rainy", "windy"
            };
            int randomWeather = (int) (Math.random() * winterWeather.length);
            System.out.println(winterWeather[randomWeather]);
        }
    }
}
