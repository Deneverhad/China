package Server;

/**
 * be patient and say hello to new player to welcome
 */
public class RuleSayHello extends Rule {


    public RuleSayHello(ServerHead head) {
        super(head);
    }

    /**
     * be patient and say hello to new player to welcome
     * @param player who done action
     * @param command what action
     * @return true if sb is new player
     */
    @Override
    protected boolean check(Player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (command.startsWith("WAITING")){
            System.out.println("Done " + this.getClass().getSimpleName());
            head.newMessageWrite("HELLO " + head.board.getClass().getSimpleName() + ";" + head.getShape() + ";" + player.getColor() + ";" + head.getAmountPlayers() + ";" + head.colors[0], player);
            return true;
        }
        return false;
    }
}
/*else if (players.size() != amountPlayers){
            player.sendMessage("WAIT");
        } else if (currentPlayer.equals(player)) {
            player.sendMessage("NOT_YOU");
        } */