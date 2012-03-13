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
    
    PrinterInterface(){
    
    }

    PrinterInterface(MemberAccount memberInfo){
        member = memberInfo;
    }
    
    private void printReceipt(Payment payment){
    
    }
    
    private void printMemberInfo(Member member){
    
    }

    void printGameInfo(Game newGame) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
