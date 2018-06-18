package com.github.JHXSMatthew.distributed_bungee.msg;

import java.util.Optional;

/**
 * Created by JHXSMatthew on 17/6/18.
 */
@Deprecated
public class VectorClock {

    private long[] clock;
    private boolean[] overflow;

    public VectorClock(long[] clock, boolean[] overflow){
        this.clock = clock;
        this.overflow = overflow;
    }

    public Optional<Long> get(int i){
        return i < length()?  Optional.of(clock[i]) : Optional.empty();
    }

    /**
     *
     * @param from
     * @return -1 from < this. 0 from == this , 1 from > this
     */
    public Optional<Integer> compare(VectorClock from, int index){
        return from.get(index)
                .flatMap(n-> this.get(index)
                        .flatMap(m -> Optional.of(unify(n - m))));
    }

    /**
     *
     * @param from
     * @return -1 from < this. 0 from == this , 1 from > this
     */
    public Optional[] compare(VectorClock from){
        int loopEnd = Math.max(from.length(), this.length());
        Optional[] rtv = new Optional[loopEnd];

        for(int i = 0 ; i < loopEnd ; i ++){
            rtv[i] = compare(from, i);
        }
        return rtv;
    }


    public int length(){
        return  clock == null ? 0 : clock.length;
    }

    public int unify(long val){
        return val > 0 ? 1 : (val < 0 ? -1 : 0);
    }

}
