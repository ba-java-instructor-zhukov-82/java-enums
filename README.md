#Java Enumerations (enum classes)

Project covers main features of Java enum class and it possible ways of using.  
Here is the code of most detailed custom enum code in the project:  

```java
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
```  
And its implemented interface:  

```java
private interface Winter {
    final String DECEMBER = "DECEMBER";
    final String JANUARY = "JANUARY";
    final String FEBRUARY = "FEBRUARY";

    void snowing();
}
```  
Also project provides testing of enum classes it consist. 
Including enum type presented above:  

```java
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
```