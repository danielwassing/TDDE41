import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKMultithreading extends Thread
{
    private String conn_string;
    private int result;

    ZKMultithreading(String _conn_str)
    {
        conn_string = _conn_str;
    }

    int get_result()
    {
        return this.result;
    }

    public void run()
    {
        ZKConnection conn;
        ZooKeeper zk;

        // znode path
        String path = "/MyFirstZnode"; // Assign path to znode

        try
        {
            conn = new ZKConnection();
            zk = conn.connect(conn_string);
        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
            this.result = 0;
            return;
        }

        try
        {

            // Stat checks the path of the znode
            Stat stat = ZKNodes.exists(path, zk);

            if (stat != null)
            {
                // String to save
                String data = Thread.currentThread().getName() + ":Changed Data";

                ZKNodes.update(path, data, zk); // Update znode data to the specified path

                //System.out.println(Thread.currentThread().getName() + " modified the data");
                this.result = 1;
            }
            conn.close();
        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
            try
            {
                conn.close();
                this.result = 0;
            }
            catch (InterruptedException e2)
            {
                //System.out.println(e2.getMessage());
            }
        }
    }
}
