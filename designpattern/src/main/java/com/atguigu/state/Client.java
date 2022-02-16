package com.atguigu.state;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args)
    {
        StateContext stateContext = new StateContext();
        stateContext.add(23);
        stateContext.add(45);
        stateContext.add(-32);
        stateContext.add(66);
        stateContext.add(23);
    }
}

abstract class AbstractState {
    StateContext stateContext;
    String stateName;
    int score;

    void addScore(int score)
    {
        System.out.println(12123);
        this.score += score;
        checkState();
        System.out.println(score + " " + this.score);
        System.out.println(this.stateContext.getAbstractState().stateName);
    }

    abstract void checkState();
}

class LowerState extends AbstractState {
    public LowerState(StateContext stateContext)
    {
        this.stateName = "不及格";
        this.stateContext = stateContext;
        this.score = 0;
    }

    public LowerState(AbstractState abstractState)
    {
        this.stateName = "不及格";
        abstractState.stateContext.setAbstractState(this);
        this.stateContext = abstractState.stateContext;
        this.score = abstractState.score;
    }


    @Override
    void checkState()
    {
        if (score > 90) {
            this.stateContext.setAbstractState(new HighState(this));
        } else if (score > 60) {
            this.stateContext.setAbstractState(new MiddleState(this));
        }
    }
}

class MiddleState extends AbstractState {

    public MiddleState(AbstractState abstractState)
    {
        this.stateName = "中等";
        abstractState.stateContext.setAbstractState(this);
        this.stateContext = abstractState.stateContext;
        this.score = abstractState.score;
    }

    @Override
    void checkState()
    {
        if (score > 90) {
            this.stateContext.setAbstractState(new HighState(this));
        } else if (score < 60) {
            this.stateContext.setAbstractState(new LowerState(this));
        }
    }
}

class HighState extends AbstractState {
    public HighState(AbstractState abstractState)
    {
        this.stateName = "优秀";
        abstractState.stateContext.setAbstractState(this);
        this.stateContext = abstractState.stateContext;
        this.score = abstractState.score;
    }

    @Override
    void checkState()
    {
        if (score < 60) {
            this.stateContext.setAbstractState(new LowerState(this));
        } else if (score < 90) {
            this.stateContext.setAbstractState(new MiddleState(this));
        }
    }
}

class StateContext {
    private AbstractState abstractState;

    public StateContext()
    {
        this.abstractState = new LowerState(this);
    }

    void add(int score)
    {
        abstractState.addScore(score);
    }

    public AbstractState getAbstractState()
    {
        return abstractState;
    }

    public void setAbstractState(AbstractState abstractState)
    {
        this.abstractState = abstractState;
    }
}
