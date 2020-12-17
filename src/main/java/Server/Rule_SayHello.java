package Server;

public class Rule_SayHello extends Rule {


    Rule_SayHello(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (command.startsWith("WAITING")){
            System.out.println("Done " + this.getClass().getSimpleName());
            head.newMessageWrite("HELLO " + head.board.getClass().getSimpleName() + ";" + head.getShape() + ";" + player.getColor() + ";" + head.getAmountPlayers(), player);
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