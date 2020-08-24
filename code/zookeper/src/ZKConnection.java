import java.io.IOException;
import java.util.concurrent.CountDownLatch;

// import zookeeper classes
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

class ZKConnection
{
    // declare zookeeper instance to access ZooKeeper ensemble
    private ZooKeeper zk;
    private final CountDownLatch connectedSignal = new CountDownLatch(1);

    // Method to connect zookeeper ensemble.
    ZooKeeper connect(String host) throws IOException,InterruptedException
    {
        zk = new ZooKeeper(host,5000,new Watcher()
        {
            public void process(WatchedEvent we)
            {
                if (we.getState() == KeeperState.SyncConnected)
                {
                    connectedSignal.countDown();
                }
            }
        });
        connectedSignal.await();
        return zk;
    }

    // Method to disconnect from zookeeper server
    void close() throws InterruptedException
    {
        zk.close();
    }





}