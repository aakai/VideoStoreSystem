/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
class PrinterInterface {
    MemberAccount member;
    Reservation resInfo;
    Game gameInfo;
    Payment paymentInfo;
    
    
    PrinterInterface(){
    }

    PrinterInterface(MemberAccount memberInfo){
        member = memberInfo;
    }
    
    private void printReceipt(Payment payment){
        System.out.println(payment.toString());
    }
    
    private void printMemberInfo(MemberAccount member){
        System.out.println(member.toString());
    }

    void printGameInfo(Game newGame) {
        System.out.println(newGame.toString());
    }

    void printReservationInfo(Reservation reservation, MemberAccount member) {
        this.member = member;
        this.resInfo = reservation;
        System.out.println(this.resInfo.toString());
        
    }

}
