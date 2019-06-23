package com.example.dell.lianxiqimo5.contract;

import com.example.dell.lianxiqimo5.ben.Bean;

public interface Contract {
void chenng (Bean bean);
    interface Model {
        void m(Contract contract);
    }

    interface View {
        void chenng (Bean bean);

    }

    interface Presenter {
        void p();
    }
}
