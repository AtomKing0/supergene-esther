package io.sentry;

import java.util.Queue;

/* JADX INFO: compiled from: SynchronizedQueue.java */
/* JADX INFO: loaded from: classes5.dex */
final class t8<E> extends s8<E> implements Queue<E> {
    private t8(Queue<E> queue) {
        super(queue);
    }

    static <E> t8<E> d(Queue<E> queue) {
        return new t8<>(queue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.sentry.s8
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Queue<E> a() {
        return (Queue) super.a();
    }

    @Override // java.util.Queue
    public E element() {
        k1 k1VarA = this.f28226b.a();
        try {
            E eElement = a().element();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return eElement;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zEquals = a().equals(obj);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zEquals;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public int hashCode() {
        k1 k1VarA = this.f28226b.a();
        try {
            int iHashCode = a().hashCode();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return iHashCode;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public boolean offer(E e10) {
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zOffer = a().offer(e10);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zOffer;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public E peek() {
        k1 k1VarA = this.f28226b.a();
        try {
            E ePeek = a().peek();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return ePeek;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public E poll() {
        k1 k1VarA = this.f28226b.a();
        try {
            E ePoll = a().poll();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return ePoll;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public E remove() {
        k1 k1VarA = this.f28226b.a();
        try {
            E eRemove = a().remove();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return eRemove;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        k1 k1VarA = this.f28226b.a();
        try {
            Object[] array = a().toArray();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return array;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        k1 k1VarA = this.f28226b.a();
        try {
            T[] tArr2 = (T[]) a().toArray(tArr);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return tArr2;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
