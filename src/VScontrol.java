
public class VScontrol {

	/**
	 * @param args
	 */
      public static Employee[] registeredEmployees= new Employee[100];
      public int count;
        
       public VScontrol(){
           count = 0;
       }
       
       public void addEmployee(Employee employee){
           registeredEmployees[count] = employee;
           count++;
       }

       public void removeEmployee(Employee employee){
           for(int i = 0; i< count; i++){
               if(registeredEmployees[i] == employee){
                   for(int j = 0; (i+j)< count; j++){
                       registeredEmployees[i+j] = registeredEmployees[i+j+1];
                   }
               }

               
           }
           count++;
       }

}
