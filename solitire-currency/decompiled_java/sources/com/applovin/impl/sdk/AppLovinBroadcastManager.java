package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinBroadcastManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f6866a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f6867b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ArrayList f6868c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Handler f6869d = new a(Looper.getMainLooper());

    public interface Receiver {
        void onReceive(Intent intent, @Nullable Map<String, Object> map);
    }

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AppLovinBroadcastManager.b();
            } else {
                super.handleMessage(message);
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f6870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map f6871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final List f6872c;

        b(Intent intent, Map map, List list) {
            this.f6870a = intent;
            this.f6871b = map;
            this.f6872c = list;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f6873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Receiver f6874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f6875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f6876d;

        c(IntentFilter intentFilter, Receiver receiver) {
            this.f6873a = intentFilter;
            this.f6874b = receiver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (f6866a) {
                ArrayList arrayList = f6868c;
                size = arrayList.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                arrayList.toArray(bVarArr);
                arrayList.clear();
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                if (bVar != null) {
                    for (c cVar : bVar.f6872c) {
                        if (cVar != null && !cVar.f6876d) {
                            cVar.f6874b.onReceive(bVar.f6870a, bVar.f6871b);
                        }
                    }
                }
            }
        }
    }

    public static void registerReceiver(Receiver receiver, IntentFilter intentFilter) {
        Map map = f6866a;
        synchronized (map) {
            c cVar = new c(intentFilter, receiver);
            ArrayList arrayList = (ArrayList) map.get(receiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                map.put(receiver, arrayList);
            }
            arrayList.add(cVar);
            Iterator<String> itActionsIterator = intentFilter.actionsIterator();
            while (itActionsIterator.hasNext()) {
                String next = itActionsIterator.next();
                Map map2 = f6867b;
                ArrayList arrayList2 = (ArrayList) map2.get(next);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    map2.put(next, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public static boolean sendBroadcast(Intent intent, @Nullable Map<String, Object> map) {
        synchronized (f6866a) {
            List listA = a(intent);
            if (listA == null) {
                return false;
            }
            f6868c.add(new b(intent, map, listA));
            Handler handler = f6869d;
            if (!handler.hasMessages(1)) {
                handler.sendEmptyMessage(1);
            }
            return true;
        }
    }

    public static void sendBroadcastSync(Intent intent, @Nullable Map<String, Object> map) {
        List<c> listA = a(intent);
        if (listA == null) {
            return;
        }
        for (c cVar : listA) {
            if (!cVar.f6876d) {
                cVar.f6874b.onReceive(intent, map);
            }
        }
    }

    public static void sendBroadcastSyncWithPendingBroadcasts(Intent intent, @Nullable Map<String, Object> map) {
        if (sendBroadcast(intent, map)) {
            b();
        }
    }

    public static boolean sendBroadcastWithAdObject(String str, Object obj) {
        HashMap map = new HashMap(1);
        map.put("ad", obj);
        return sendBroadcast(new Intent(str), map);
    }

    public static void unregisterReceiver(Receiver receiver) {
        Map map = f6866a;
        synchronized (map) {
            List<c> list = (List) map.remove(receiver);
            if (list == null) {
                return;
            }
            for (c cVar : list) {
                cVar.f6876d = true;
                Iterator<String> itActionsIterator = cVar.f6873a.actionsIterator();
                while (itActionsIterator.hasNext()) {
                    String next = itActionsIterator.next();
                    List list2 = (List) f6867b.get(next);
                    if (list2 != null) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            if (((c) it.next()).f6874b == receiver) {
                                cVar.f6876d = true;
                                it.remove();
                            }
                        }
                        if (list2.size() <= 0) {
                            f6867b.remove(next);
                        }
                    }
                }
            }
        }
    }

    private static List a(Intent intent) {
        synchronized (f6866a) {
            String action = intent.getAction();
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            List<c> list = (List) f6867b.get(action);
            if (list == null) {
                return null;
            }
            ArrayList arrayList = null;
            for (c cVar : list) {
                if (!cVar.f6875c && cVar.f6873a.match(action, null, scheme, data, categories, "AppLovinBroadcastManager") >= 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cVar);
                    cVar.f6875c = true;
                }
            }
            if (arrayList == null) {
                return null;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((c) it.next()).f6875c = false;
            }
            return arrayList;
        }
    }
}
