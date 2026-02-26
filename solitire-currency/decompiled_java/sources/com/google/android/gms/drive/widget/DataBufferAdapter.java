package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DataBufferAdapter<T> extends BaseAdapter {
    private static final GmsLogger zzbz = new GmsLogger("DataBufferAdapter", "");
    private final int fieldId;
    private final int resource;
    private final Context zzgw;
    private int zzmz;
    private final List<DataBuffer<T>> zzna;
    private final LayoutInflater zznb;
    private boolean zznc;

    public DataBufferAdapter(Context context, int i10, int i11, List<DataBuffer<T>> list) {
        this.zznc = true;
        this.zzgw = context;
        this.zzmz = i10;
        this.resource = i10;
        this.fieldId = i11;
        this.zzna = list;
        this.zznb = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private final View zza(int i10, View view, ViewGroup viewGroup, int i11) {
        if (view == null) {
            view = this.zznb.inflate(i11, viewGroup, false);
        }
        try {
            int i12 = this.fieldId;
            TextView textView = i12 == 0 ? (TextView) view : (TextView) view.findViewById(i12);
            T item = getItem(i10);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return view;
        } catch (ClassCastException e10) {
            zzbz.e("DataBufferAdapter", "You must supply a resource ID for a TextView", e10);
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e10);
        }
    }

    public void append(DataBuffer<T> dataBuffer) {
        this.zzna.add(dataBuffer);
        if (this.zznc) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        Iterator<DataBuffer<T>> it = this.zzna.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.zzna.clear();
        if (this.zznc) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.zzgw;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Iterator<DataBuffer<T>> it = this.zzna.iterator();
        int count = 0;
        while (it.hasNext()) {
            count += it.next().getCount();
        }
        return count;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        return zza(i10, view, viewGroup, this.zzmz);
    }

    @Override // android.widget.Adapter
    public T getItem(int i10) throws CursorIndexOutOfBoundsException {
        int i11 = i10;
        for (DataBuffer<T> dataBuffer : this.zzna) {
            int count = dataBuffer.getCount();
            if (count > i11) {
                try {
                    return dataBuffer.get(i11);
                } catch (CursorIndexOutOfBoundsException unused) {
                    throw new CursorIndexOutOfBoundsException(i10, getCount());
                }
            }
            i11 -= count;
        }
        throw new CursorIndexOutOfBoundsException(i10, getCount());
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        return zza(i10, view, viewGroup, this.resource);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.zznc = true;
    }

    public void setDropDownViewResource(int i10) {
        this.zzmz = i10;
    }

    public void setNotifyOnChange(boolean z10) {
        this.zznc = z10;
    }

    public DataBufferAdapter(Context context, int i10, int i11) {
        this(context, i10, i11, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i10, List<DataBuffer<T>> list) {
        this(context, i10, 0, list);
    }

    public DataBufferAdapter(Context context, int i10) {
        this(context, i10, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i10, int i11, DataBuffer<T>... dataBufferArr) {
        this(context, i10, i11, Arrays.asList(dataBufferArr));
    }

    public DataBufferAdapter(Context context, int i10, DataBuffer<T>... dataBufferArr) {
        this(context, i10, 0, Arrays.asList(dataBufferArr));
    }
}
