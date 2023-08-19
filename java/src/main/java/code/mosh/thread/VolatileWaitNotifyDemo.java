package code.mosh.thread;

public class VolatileWaitNotifyDemo {
    public static void main(String[] args) {
        var status = new DownloadStatus();

        Thread t1 = new Thread(new DownloadFileTask(status));
        Thread t2 = new Thread( () -> {
            //while (!status.isDone()){} // this is wasting cpy cycles. bad bad

            while (!status.isDone) {
                synchronized (status) { // if you won't synchronized, IllegalMonitorException not the owner of object
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            System.out.println("Download complete update received.");
        });


        t1.start();
        t2.start();

    }

    private static class DownloadFileTask implements Runnable {
        private DownloadStatus status;
        public DownloadFileTask(DownloadStatus status) {
            this.status = status;
        }

        @Override
        public void run() {
            for (var i = 0 ;i < 4; i++) {
                status.incrementBytes();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Downloading");
            }

            status.done(); // marking the completion and
            synchronized (status) {  // if you won't synchronized, IllegalMonitorException not the owner of object
                status.notifyAll(); // notify all threads have marked wait() for status object
            }
        }
    }

    private static class DownloadStatus {
        volatile private boolean isDone; // remove the volatile first to see the problem

        private int bytes;

        public void incrementBytes() {
            this.bytes++;
        }

        public boolean isDone() {
            return isDone;
        }

        public void done() {
            isDone = true;
        }
    }
}
