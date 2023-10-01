public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Thread t1 = new Thread(new SmsCampaign());
        Thread t2 = new Thread(new EmailCampaign());
        t1.setName("SmsCampaign");
        t2.setName("EmailCampaign");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();

        try {
            t2.join();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inside main");
    }

    public static class SmsCampaign implements Runnable{

        @Override
        public void run() {
            for (int i =1; i<10; i++) {
                System.out.println(Thread.currentThread().getName());
                if(i==5){
                    Thread.currentThread().yield(); // Thread ready to release CPU Usage
                }
            }

        }
    }

    public static class EmailCampaign implements Runnable{

        @Override
        public void run() {
            for(int i =1; i <10; i++){
            System.out.println(Thread.currentThread().getName());
            }

        }
    }
}