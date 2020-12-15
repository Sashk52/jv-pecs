package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.BulldozerProducer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.ExcavatorProducer;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import core.mate.academy.model.TruckProducer;
import java.util.ArrayList;
import java.util.List;

public class MachineServiceImpl<T extends Machine> implements MachineService<T> {

    @Override
    public List<Machine> getAll(Class<? extends T> type) {
        if (type == Bulldozer.class) {
            return new ArrayList(new BulldozerProducer().get());
        } else if (type == Truck.class) {
            return new ArrayList(new TruckProducer().get());
        } else if (type == Excavator.class) {
            return new ArrayList(new ExcavatorProducer().get());
        }
        return new ArrayList<>();
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0;i < machines.size();i++) {
            machines.set(i,value);
        }

    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (Machine machine:machines) {
            machine.doWork();
        }
    }
}
