package com.king.amp.sa;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: AbmMediaPlayerChapterAdMediaAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public class u extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<Drawable> f16973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AbmMediaPlayerActivity f16974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final q f16975k;

    /* JADX INFO: compiled from: AbmMediaPlayerChapterAdMediaAdapter.java */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (u.this.f16974j != null) {
                u.this.f16974j.V();
            }
            if (u.this.f16975k == null) {
                return false;
            }
            u.this.f16975k.R();
            return false;
        }
    }

    /* JADX INFO: compiled from: AbmMediaPlayerChapterAdMediaAdapter.java */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ImageView f16977b;

        public b(View view) {
            super(view);
            this.f16977b = (ImageView) view.findViewById(j6.f.f28717e);
        }
    }

    public u(List<Drawable> list, AbmMediaPlayerActivity abmMediaPlayerActivity) {
        this.f16973i = list;
        this.f16974j = abmMediaPlayerActivity;
        this.f16975k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i10) {
        bVar.f16977b.setImageDrawable(this.f16973i.get(i10));
        bVar.f16977b.setOnTouchListener(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(j6.g.f28749k, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f16973i.size();
    }

    public u(List<Drawable> list, q qVar) {
        this.f16973i = list;
        this.f16974j = null;
        this.f16975k = qVar;
    }
}
