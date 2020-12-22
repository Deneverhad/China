package Server;

public abstract class RuleMove extends Rule {

    int new_x;
    int new_y;
    LogicBoard board;

    RuleMove(serverHead head, LogicBoard board) {
        super(head);
        this.board = board;
    }


    @Override
    boolean check(Player player, String command){
        if (command.startsWith("MOVE")) {
            try {
                new_x = Integer.parseInt(command.substring(5).split(";")[0]);
                new_y = Integer.parseInt(command.substring(5).split(";")[1]);
                if (canDo(player)){
                    return true;
                }
            }catch (Exception e){
                head.newMessageWrite("BAD_DATA", player);
            }
        }
        return false;

    }

    protected abstract boolean canDo(Player player);

    void doMove(){
        board.setFieldColor(new_x, new_y, head.currentPlayer.getColor());
        board.setFieldColor(head.currentX, head.currentY, "white");
        for (Player playerr: head.getPlayers()) {
            head.newMessageWrite("CHANGE " + new_x + ";" + new_y + ";" + head.currentPlayer.getColor(), playerr);
            head.newMessageWrite("CHANGE " + head.currentX + ";" + head.currentY + ";" + "white", playerr);
        }

        head.setCurrentX(new_x);
        head.setCurrentY(new_y);

    }
}
