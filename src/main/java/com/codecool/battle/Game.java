package com.codecool.battle;


public class Game {
    private Player[] players;
    private int currentPlayerInt;
    private Deck deck;
    private CardsOnTable cardsOnTable;
    private int numberOfHumanPlayers;
    private int numberOfComputerPlayers;
    private IO io;

    public Game(int numberOfHumanPlayers, int numberOfComputerPlayers, IO io) {
        this.players = new Player[numberOfHumanPlayers + numberOfComputerPlayers];
        this.numberOfHumanPlayers = numberOfHumanPlayers;
        this.numberOfComputerPlayers = numberOfComputerPlayers;
        this.io = io;
        createHumanPlayers();
        createComputerPlayers();
        setPlayersNames(io);
    }

    public IO getIo() {
        return io;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void changeToNextPlayer(){
        currentPlayerInt += 1;
        if (currentPlayerInt == players.length){
            currentPlayerInt = 0;
        }
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerInt];
    }

    public Deck getDeck() {
        return deck;
    }

    public CardsOnTable getCardsOnTable() {
        return cardsOnTable;
    }

    public void createHumanPlayers() {
        for (int i = 0; i < numberOfHumanPlayers; i++) {
            Player player = new HumanPlayer(io);
            players[i] = player;
        }
    }

    public void createComputerPlayers() {
        for (int i = numberOfHumanPlayers; i < numberOfHumanPlayers + numberOfComputerPlayers; i++) {
            Player player = new ComputerPlayer();
            players[i] = player;
        }
    }

    public void setPlayersNames(IO io) {
        int count = 1;
        for (Player player : players) {
            String humanOrComputer = player instanceof HumanPlayer ? "player " : "computer ";
            player.setName(io.gatherInput("Type in the name for " + humanOrComputer + count + "."));
            count++;
        }
    }

}
