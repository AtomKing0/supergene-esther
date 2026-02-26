package com.applovin.impl;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.d;
import com.applovin.impl.k2;
import com.applovin.impl.v2;
import com.applovin.impl.x2;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w2 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private x2 f7669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ListView f7670b;

    class a implements k2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v2 f7671a;

        /* JADX INFO: renamed from: com.applovin.impl.w2$a$a, reason: collision with other inner class name */
        class C0178a implements d.b {
            C0178a() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                maxDebuggerMultiAdActivity.initialize(a.this.f7671a);
            }
        }

        a(v2 v2Var) {
            this.f7671a = v2Var;
        }

        @Override // com.applovin.impl.k2.a
        public void a(d2 d2Var, j2 j2Var) {
            if (d2Var.b() != x2.a.TEST_ADS.ordinal()) {
                z6.a(j2Var.c(), j2Var.b(), w2.this);
                return;
            }
            com.applovin.impl.sdk.j jVarO = this.f7671a.o();
            v2.b bVarY = this.f7671a.y();
            if (!w2.this.f7669a.a(d2Var)) {
                z6.a(j2Var.c(), j2Var.b(), w2.this);
                return;
            }
            if (v2.b.READY == bVarY) {
                d.a(w2.this, MaxDebuggerMultiAdActivity.class, jVarO.e(), new C0178a());
            } else if (v2.b.DISABLED != bVarY) {
                z6.a(j2Var.c(), j2Var.b(), w2.this);
            } else {
                jVarO.l0().a();
                z6.a(j2Var.c(), j2Var.b(), w2.this);
            }
        }
    }

    public w2() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        x2 x2Var = this.f7669a;
        if (x2Var != null) {
            return x2Var.h().o();
        }
        return null;
    }

    public void initialize(v2 v2Var) {
        setTitle(v2Var.g());
        x2 x2Var = new x2(v2Var, this);
        this.f7669a = x2Var;
        x2Var.a(new a(v2Var));
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f7670b = listView;
        listView.setAdapter((ListAdapter) this.f7669a);
    }

    @Override // com.applovin.impl.d3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f7669a.h().b().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f7669a.k();
            this.f7669a.c();
        }
    }
}
