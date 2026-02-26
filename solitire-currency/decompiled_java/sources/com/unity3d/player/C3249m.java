package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Map;

/* JADX INFO: renamed from: com.unity3d.player.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3249m implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerStatusQueryCallback f24143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f24144b = Looper.myLooper();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f24145c;

    public C3249m(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.f24143a = iAssetPackManagerStatusQueryCallback;
        this.f24145c = strArr;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        if (this.f24143a == null) {
            return;
        }
        int i10 = 0;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map mapPackStates = assetPackStates.packStates();
            int size = mapPackStates.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (AssetPackState assetPackState : mapPackStates.values()) {
                strArr[i10] = assetPackState.name();
                iArr[i10] = assetPackState.status();
                iArr2[i10] = assetPackState.errorCode();
                i10++;
            }
            new Handler(this.f24144b).post(new RunnableC3247l(this.f24143a, assetPackStates.totalBytes(), strArr, iArr, iArr2));
        } catch (RuntimeExecutionException e10) {
            e = e10;
            String message = e.getMessage();
            String[] strArr2 = this.f24145c;
            int length = strArr2.length;
            int i11 = 0;
            while (true) {
                int errorCode2 = -100;
                if (i11 >= length) {
                    String[] strArr3 = this.f24145c;
                    int[] iArr3 = new int[strArr3.length];
                    int[] iArr4 = new int[strArr3.length];
                    for (int i12 = 0; i12 < this.f24145c.length; i12++) {
                        iArr3[i12] = 0;
                        AssetPackException cause = e;
                        while (true) {
                            if (cause instanceof AssetPackException) {
                                errorCode = cause.getErrorCode();
                                break;
                            }
                            cause = cause.getCause();
                            if (cause == null) {
                                errorCode = -100;
                                break;
                            }
                        }
                        iArr4[i12] = errorCode;
                    }
                    new Handler(this.f24144b).post(new RunnableC3247l(this.f24143a, 0L, this.f24145c, iArr3, iArr4));
                    return;
                }
                String str = strArr2[i11];
                if (message.contains(str)) {
                    Handler handler = new Handler(this.f24144b);
                    IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback = this.f24143a;
                    String[] strArr4 = {str};
                    int[] iArr5 = {0};
                    int[] iArr6 = new int[1];
                    while (true) {
                        if (!(e instanceof AssetPackException)) {
                            e = e.getCause();
                            if (e == null) {
                                break;
                            }
                        } else {
                            errorCode2 = e.getErrorCode();
                            break;
                        }
                    }
                    iArr6[0] = errorCode2;
                    handler.post(new RunnableC3247l(iAssetPackManagerStatusQueryCallback, 0L, strArr4, iArr5, iArr6));
                    return;
                }
                i11++;
            }
        }
    }
}
