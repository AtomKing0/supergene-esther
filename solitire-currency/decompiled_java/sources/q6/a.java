package q6;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.samsung.android.gamesdk.IGameSDKService;

/* JADX INFO: compiled from: GameSDKManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IGameSDKService f33164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f33165b = -1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f33166c = new int[0];

    public a() {
        this.f33164a = null;
        IBinder service = ServiceManager.getService("gamesdk");
        if (service != null) {
            this.f33164a = IGameSDKService.Stub.asInterface(service);
            d();
        }
    }

    private void d() {
        IGameSDKService iGameSDKService = this.f33164a;
        if (iGameSDKService == null) {
            Log.w("GameSDKManager", "gamesdk system service is not available");
            return;
        }
        try {
            this.f33165b = Float.parseFloat(iGameSDKService.getVersion());
            Log.w("GameSDKManager", "updateServiceVersion() : " + this.f33165b);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public String a() {
        IGameSDKService iGameSDKService = this.f33164a;
        if (iGameSDKService == null) {
            Log.w("GameSDKManager", "gamesdk system service is not available");
            return "0";
        }
        try {
            return iGameSDKService.getVersion();
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return "0";
        }
    }

    public boolean b(int i10) {
        IGameSDKService iGameSDKService = this.f33164a;
        if (iGameSDKService == null) {
            Log.w("GameSDKManager", "gamesdk system service is not available");
            return false;
        }
        if (this.f33165b < 3.4f) {
            Log.w("GameSDKManager", "setCpuBoostMode() API is not supported this GameSDK Version");
            return false;
        }
        try {
            return iGameSDKService.setCpuBoostMode(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public boolean c(int i10) {
        IGameSDKService iGameSDKService = this.f33164a;
        if (iGameSDKService == null) {
            Log.w("GameSDKManager", "gamesdk system service is not available");
            return false;
        }
        if (this.f33165b < 3.4f) {
            Log.w("GameSDKManager", "setGpuBoostMode() API is not supported this GameSDK Version");
            return false;
        }
        try {
            return iGameSDKService.setGpuBoostMode(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
