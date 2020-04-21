public class GumballMachine
{
    private interface State
    {
        String noGumballToRemoveMessage = "There wasn't a gumball in there to begin with!";
        String noQuarterToRemoveMessage = "There wasn't a quarter in the slot to begin with!";
        String insertingQuarterMessage = "Quarter inserted";
        String quarterAlreadyInsertedMessage = "There is already a quarter in the slot!";
        String removingQuarterMessage = "Quarter removed";
        String noQuarterAndTurningMessage = "You need to insert a quarter first to get a gumball!";
        String noGumballsAvailableMessage = "No gumballs in machine!";
        String addGumballsMessage = "Gumballs added";
        String consumingQuarterMessage = "Quarter consumed";
        String dispensingGumballMessage = "Gumball dispensed";

        void addGumballs(int numberToAdd, GumballMachine gumballMachine);
        void insertQuarter(GumballMachine gumballMachine);
        void removeQuarter(GumballMachine gumballMachine);
        void turnHandle(GumballMachine gumballMachine);
    }

    private int coins, gumballs;
    private State currentState;

    public int getCoins()
    {
        return coins;
    }

    public int getGumballs()
    {
        return gumballs;
    }

    public GumballMachine()
    {
        coins = 0;
        gumballs = 0;
        currentState = new NoGumballs_NoQuarter();
    }

    public void addGumballs(int numberToAdd)
    {
        currentState.addGumballs(numberToAdd, this);
    }

    public void insertQuarter()
    {
        currentState.insertQuarter(this);
    }

    public void removeQuarter()
    {
        currentState.removeQuarter(this);
    }

    public void turnHandle()
    {
        currentState.turnHandle(this);
    }

    private static class NoGumballs_NoQuarter implements State
    {
        @Override
        public void addGumballs(int numberToAdd, GumballMachine gumballMachine)
        {
            gumballMachine.gumballs += numberToAdd;
            System.out.println(addGumballsMessage);
            gumballMachine.currentState = new Gumballs_NoQuarter();
        }

        @Override
        public void insertQuarter(GumballMachine gumballMachine)
        {
            System.out.println(insertingQuarterMessage);
            System.out.println(noGumballsAvailableMessage);
            gumballMachine.currentState = new NoGumballs_Quarter();
        }

        @Override
        public void removeQuarter(GumballMachine gumballMachine)
        {
            System.out.println(noQuarterToRemoveMessage);
        }

        @Override
        public void turnHandle(GumballMachine gumballMachine)
        {
            System.out.println(noQuarterAndTurningMessage);
            System.out.println(noGumballToRemoveMessage);
        }
    }

    private static class NoGumballs_Quarter implements State
    {
        @Override
        public void addGumballs(int numberToAdd, GumballMachine gumballMachine)
        {
            gumballMachine.gumballs += numberToAdd;
            System.out.println(addGumballsMessage);
            gumballMachine.currentState = new Gumballs_Quarter();
        }

        @Override
        public void insertQuarter(GumballMachine gumballMachine)
        {
            System.out.println(quarterAlreadyInsertedMessage);
            System.out.println(noGumballToRemoveMessage);
        }

        @Override
        public void removeQuarter(GumballMachine gumballMachine)
        {
            System.out.println(removingQuarterMessage);
            System.out.println(noGumballToRemoveMessage);
            gumballMachine.currentState = new NoGumballs_NoQuarter();
        }

        @Override
        public void turnHandle(GumballMachine gumballMachine)
        {
            System.out.println(noGumballsAvailableMessage);
        }
    }

    private static class Gumballs_Quarter implements State
    {
        @Override
        public void addGumballs(int numberToAdd, GumballMachine gumballMachine)
        {
            gumballMachine.gumballs += numberToAdd;
            System.out.println(addGumballsMessage);
        }

        @Override
        public void insertQuarter(GumballMachine gumballMachine)
        {
            System.out.println(quarterAlreadyInsertedMessage);
        }

        @Override
        public void removeQuarter(GumballMachine gumballMachine)
        {
            System.out.println(removingQuarterMessage);
            gumballMachine.currentState = new Gumballs_NoQuarter();
        }

        @Override
        public void turnHandle(GumballMachine gumballMachine)
        {
            ++gumballMachine.coins;
            System.out.println(consumingQuarterMessage);
            System.out.println(dispensingGumballMessage);

            if (--gumballMachine.gumballs == 0)
            {
                System.out.println(noGumballsAvailableMessage);
                gumballMachine.currentState = new NoGumballs_NoQuarter();
            }
            else
            {
                gumballMachine.currentState = new Gumballs_NoQuarter();
            }
        }
    }

    private static class Gumballs_NoQuarter implements State
    {
        @Override
        public void addGumballs(int numberToAdd, GumballMachine gumballMachine)
        {
            gumballMachine.gumballs += numberToAdd;
            System.out.println(addGumballsMessage);
        }

        @Override
        public void insertQuarter(GumballMachine gumballMachine)
        {
            System.out.println(insertingQuarterMessage);
            gumballMachine.currentState = new Gumballs_Quarter();
        }

        @Override
        public void removeQuarter(GumballMachine gumballMachine)
        {
            System.out.println(noQuarterToRemoveMessage);
        }

        @Override
        public void turnHandle(GumballMachine gumballMachine)
        {
            System.out.println(noQuarterAndTurningMessage);
        }
    }
}
