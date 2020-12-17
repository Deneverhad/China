package Server;

public class RuleMove_SkipTurn extends RuleMove {


    RuleMove_SkipTurn(serverHead head, LogicBoard board) {
        super(head, board);
    }

    @Override
    protected boolean canDo(Player player) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if(head.getCurrentX() == new_x && new_y == head.getCurrentY()){
            System.out.println("Done " + this.getClass().getSimpleName());
            head.nextPlayer();
            head.setCurrentX(-1);
            head.setCurrentY(-1);
            return true;
        }
        return false;
    }
}
