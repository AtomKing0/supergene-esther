package com.applovin.impl.communicator;

import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f4982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f4983b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f4984c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f4985d = new Object();

    private Queue a(String str) {
        LinkedList linkedList;
        synchronized (this.f4985d) {
            Queue queue = (Queue) this.f4984c.get(str);
            linkedList = queue != null ? new LinkedList(queue) : new LinkedList();
        }
        return linkedList;
    }

    private void c(final CommunicatorMessageImpl communicatorMessageImpl) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorA = a();
        this.f4982a = scheduledThreadPoolExecutorA;
        scheduledThreadPoolExecutorA.execute(new Runnable() { // from class: com.applovin.impl.communicator.a
            @Override // java.lang.Runnable
            public final void run() {
                AppLovinBroadcastManager.sendBroadcastSync(communicatorMessageImpl, null);
            }
        });
    }

    public void maybeSendStickyMessages(String str) {
        Iterator it = a(str).iterator();
        while (it.hasNext()) {
            c((CommunicatorMessageImpl) it.next());
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorMessagingService
    public void publish(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        c(appLovinCommunicatorMessage);
        b(appLovinCommunicatorMessage);
    }

    public String toString() {
        return "MessagingServiceImpl{}";
    }

    private void b(CommunicatorMessageImpl communicatorMessageImpl) {
        if (communicatorMessageImpl.sticky) {
            synchronized (this.f4985d) {
                Queue queue = (Queue) this.f4984c.get(communicatorMessageImpl.getTopic());
                if (queue != null) {
                    queue.add(communicatorMessageImpl);
                    if (queue.size() > 10) {
                        queue.remove();
                    }
                } else {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(communicatorMessageImpl);
                    this.f4984c.put(communicatorMessageImpl.getTopic(), linkedList);
                }
            }
        }
    }

    private ScheduledThreadPoolExecutor a() {
        synchronized (this.f4983b) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f4982a;
            if (scheduledThreadPoolExecutor != null) {
                return scheduledThreadPoolExecutor;
            }
            return new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.applovin.impl.communicator.b
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return MessagingServiceImpl.a(runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "AppLovinSdk:communicator");
        thread.setPriority(1);
        thread.setDaemon(true);
        return thread;
    }
}
