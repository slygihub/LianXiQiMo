package com.example.dell.lianxiqimo4.contract;

import com.example.dell.lianxiqimo4.Ben;

public interface Contract {
    void cheng(Ben ben);
    interface Model {
        void m(Contract contract);
    }

    interface View {
        void cheng(Ben ben);
    }

    interface Presenter {
        void p();
    }
}
