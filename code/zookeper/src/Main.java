public class Main {

    public static void main(String[] args)
    {
        // Number of tests to run
        int test_runs = 50;

        for (int j = 0; j < test_runs; j++)
        {
            // Number of threads per server
            int threads_per_server = 16;

            // Number of servers
            int num_servers = 7;

            // Array of all child threads
            ZKMultithreading[] child_array = new ZKMultithreading[threads_per_server * num_servers];

            // Create child threads, store them in the array and start them
            for (int i = 0; i < threads_per_server; i++)
            {
                ZKMultithreading child1 = new ZKMultithreading("localhost:2181");
                ZKMultithreading child2 = new ZKMultithreading("localhost:2182");
                ZKMultithreading child3 = new ZKMultithreading("localhost:2183");
                ZKMultithreading child4 = new ZKMultithreading("localhost:2184");
                ZKMultithreading child5 = new ZKMultithreading("localhost:2185");
                ZKMultithreading child6 = new ZKMultithreading("localhost:2186");
                ZKMultithreading child7 = new ZKMultithreading("localhost:2187");
                child_array[i * num_servers] = child1;
                child_array[i * num_servers + 1] = child2;
                child_array[i * num_servers + 2] = child3;
                child_array[i * num_servers + 3] = child4;
                child_array[i * num_servers + 4] = child5;
                child_array[i * num_servers + 5] = child6;
                child_array[i * num_servers + 6] = child7;
                child1.start();
                child2.start();
                child3.start();
                child4.start();
                child5.start();
                child6.start();
                child7.start();
            }

            try
            {
                int num_succeeded = 0;
                for (ZKMultithreading thread : child_array) {
                    thread.join();
                    if (thread.get_result() == 1) {
                        num_succeeded++;
                    }
                }
                System.out.println(num_succeeded);
            } catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
