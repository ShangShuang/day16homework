package com.example.day16homework.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModle {
    private CompositeDisposable compositeDisposable;

    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            synchronized (BaseModle.class) {
                if (compositeDisposable == null) {
                    compositeDisposable = new CompositeDisposable();
                }
            }
        }
        compositeDisposable.add(disposable);
    }

    public void destroy() {
        compositeDisposable.dispose();
    }

    public void removeDisposable(Disposable disposable) {
        if (compositeDisposable != null) {
            compositeDisposable.remove(disposable);
        }
    }
}
