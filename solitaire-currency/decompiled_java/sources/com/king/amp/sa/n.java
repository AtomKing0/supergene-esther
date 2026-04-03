package com.king.amp.sa;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.Map;

/* JADX INFO: compiled from: AbmAdCommonViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class n extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MutableLiveData<Map<String, String>> f16823a = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutableLiveData<Boolean> f16824b = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutableLiveData<Integer> f16825c = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MutableLiveData<Integer> f16826d = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MutableLiveData<Integer> f16827e = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MutableLiveData<Integer> f16828f = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MutableLiveData<Map<String, String>> f16829g = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MutableLiveData<Integer> f16830h = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MutableLiveData<Integer> f16831i = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MutableLiveData<Integer> f16832j = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MutableLiveData<Boolean> f16833k = new MutableLiveData<>();

    LiveData<Map<String, String>> a() {
        return this.f16829g;
    }

    LiveData<Integer> b() {
        return this.f16831i;
    }

    LiveData<Integer> c() {
        return this.f16830h;
    }

    LiveData<Integer> d() {
        return this.f16825c;
    }

    LiveData<Boolean> e() {
        return this.f16833k;
    }

    LiveData<Map<String, String>> f() {
        return this.f16823a;
    }

    LiveData<Integer> g() {
        return this.f16832j;
    }

    LiveData<Integer> h() {
        return this.f16827e;
    }

    LiveData<Integer> i() {
        return this.f16826d;
    }

    LiveData<Boolean> j() {
        return this.f16824b;
    }

    LiveData<Integer> k() {
        return this.f16828f;
    }

    void l(Map<String, String> map) {
        Log.d("AbmAdCommonViewModel", "onChapterAdNextPageChanged called with" + map);
        this.f16829g.setValue(map);
    }

    void m(int i10) {
        this.f16831i.setValue(Integer.valueOf(i10));
    }

    void n(Map<String, String> map) {
        Log.d("AbmAdCommonViewModel", "onLayoutConfigMapChanged called with" + map);
        this.f16823a.setValue(map);
    }

    void o(int i10) {
        Log.d("AbmAdCommonViewModel", "onProceedToNextChapter called with " + i10);
        this.f16832j.setValue(Integer.valueOf(i10));
    }

    void p(Boolean bool) {
        Log.d("AbmAdCommonViewModel", "onRewardGranted called with" + bool);
        this.f16824b.setValue(bool);
    }

    void q() {
        Log.d("AbmAdCommonViewModel", "pauseProgressBar");
        this.f16827e.setValue(0);
    }

    void r() {
        Log.d("AbmAdCommonViewModel", "resumeProgressBar");
        this.f16827e.setValue(1);
    }

    void s(Integer num) {
        Log.d("AbmAdCommonViewModel", "setCircularProgressBarVisibility called with" + num);
        this.f16830h.setValue(num);
    }

    void t(Integer num) {
        Log.d("AbmAdCommonViewModel", "setCtaButtonVisibility called with" + num);
        this.f16825c.setValue(num);
    }

    void u(boolean z10) {
        Log.d("AbmAdCommonViewModel", "setEnableCtaButton called");
        this.f16833k.setValue(Boolean.valueOf(z10));
    }

    void v(Integer num) {
        Log.d("AbmAdCommonViewModel", "setProgressVisibility called with" + num);
        this.f16826d.setValue(num);
    }

    void w(Integer num) {
        Log.d("AbmAdCommonViewModel", "setScreenGradientVisibility called with" + num);
        this.f16828f.setValue(num);
    }

    void x() {
        Log.d("AbmAdCommonViewModel", "startProgressBar");
        this.f16827e.setValue(2);
    }
}
