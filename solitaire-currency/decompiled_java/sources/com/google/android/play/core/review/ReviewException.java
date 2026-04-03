package com.google.android.play.core.review;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.play:review@@2.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ReviewException extends ApiException {
    public ReviewException(int i10) {
        super(new Status(i10, String.format(Locale.getDefault(), "Review Error(%d): %s", Integer.valueOf(i10), com.google.android.play.core.review.model.zza.zza(i10))));
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
