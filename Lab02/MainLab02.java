package Lab02;

public class MainLab02 {
    public static void main (String arg[]){
        String productStyle;
        Client client;
//        System.out.println("Product Catagory: ");
//        System.out.println("1.Modern");
//        System.out.println("2.Victorian");
//        System.out.println("3.Rustic");
//        System.out.println("Enter your Product style Choice: ");
        String UID1 ="101";
        String UID2 = "102";
        String UID3 = "103";
        for(int i=0;i<3;i++){
            if(i==0){
                client = new Client( ModernFurnitureFactory.getInstance(),UID1);
                client.printing();

            }
            else if(i==1){
                client = new Client( ModernFurnitureFactory.getInstance(),UID2);
                client.printing();
            }
            else if(i==2){

                client = new Client( ModernFurnitureFactory.getInstance(),UID3);
                client.printing();
            }

        }
    }

}
