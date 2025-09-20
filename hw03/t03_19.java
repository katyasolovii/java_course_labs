package hw03;

public class t03_19 {
    public static void main(String[] args) {
        Flight[] flights = new Flight[10];
        flights[0] = new Flight("Kyiv", "F101", "08:30", new String[]{"Monday", "Wednesday", "Friday"});
        flights[1] = new Flight("Lviv", "F102", "12:15", new String[]{"Tuesday", "Thursday"});
        flights[2] = new Flight("Kharkiv", "F103", "06:45", new String[]{"Monday", "Saturday"});
        flights[3] = new Flight("Odessa", "F104", "14:00", new String[]{"Wednesday", "Sunday"});
        flights[4] = new Flight("Ternopil", "F105", "10:20", new String[]{"Friday", "Sunday"});
        flights[5] = new Flight("Kyiv", "F106", "09:33", new String[]{"Tuesday", "Friday"});
        flights[6] = new Flight("Kyiv", "F107", "10:32", new String[]{"Monday", "Friday", "Sunday"});
        flights[7] = new Flight("Mykolaiv", "F108", "07:45", new String[]{"Monday", "Sunday", "Wednesday", "Thursady"});
        flights[8] = new Flight("Mukachevo", "F109", "01:50", new String[]{"Monday", "Friday"});
        flights[9] = new Flight("Uzhhorod", "F110", "05:30", new String[]{"Wednesday", "Friday", "Sunday"});

        System.out.println("Flights to Kyiv sorted by departure time:");
        Flight[] kyivFlights = Flight.sortByDestination(flights, "Kyiv");
        for (int i = 0; i < kyivFlights.length; i++) {
            System.out.println(kyivFlights[i]);
        }

        System.out.println("\nFlights on Friday:");
        Flight[] fridayFlights = Flight.sortByDay(flights, "Friday");
        for (int i = 0; i < fridayFlights.length; i++) {
            System.out.println(fridayFlights[i]);
        }

        System.out.println("\nFlights on Monday:");
        Flight[] mondayFlights = Flight.sortByDay(flights, "Monday");
        for (int i = 0; i < mondayFlights.length; i++) {
            System.out.println(fridayFlights[i]);
        }
    }
}


class Flight {
    String destination;
    String flightNumber;
    String departureTime;
    String[] daysOfWeek;

    public Flight(String destination, String flightNumber, String departureTime, String[] daysOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.daysOfWeek = daysOfWeek;
    }


    @Override
    public String toString() {
        return flightNumber + " " + destination + " " + departureTime;
    }


    public static Flight[] sortByDestination(Flight[] flights, String destination) {
        int count = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[i].destination.equals(destination)) {
                count++;
            }
        }

        Flight[] res = new Flight[count];
        int idx = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[i].destination.equals(destination)) {
                res[idx] = flights[i];
                idx++;
            }
        }

        for (int i = 0; i < res.length - 1; i++) {
            for (int j = 0; j < res.length - i - 1; j++) {
                if (res[j].departureTime.compareTo(res[j + 1].departureTime) > 0) {
                    Flight temp = res[j];
                    res[j] = res[j + 1];
                    res[j + 1] = temp;
                }
            }
        }

        return res;
    }


    public static Flight[] sortByDay(Flight[] flights, String day) {
        int count = 0;
        for (int i = 0; i < flights.length; i++) {
            for (int j = 0; j < flights[i].daysOfWeek.length; j++) {
                if (flights[i].daysOfWeek[j].equals(day)) {
                    count++;
                    break;
                }
            }
        }

        Flight[] res = new Flight[count];
        int idx = 0;
        for (int i = 0; i < flights.length; i++) {
            for (int j = 0; j < flights[i].daysOfWeek.length; j++) {
                if (flights[i].daysOfWeek[j].equals(day)) {
                    res[idx] = flights[i];
                    idx++;
                    break;
                }
            }
        }

        return res;
    }
}
