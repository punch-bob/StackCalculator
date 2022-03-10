package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext 
{
    private Stack<Double> stack;
    private Map<String, Double> variableMap;
    public ExecutionContext()
    {
        this.stack = new Stack<>();
        this.variableMap = new HashMap<>();
    }

    public Stack<Double> getStack()
    {
        return this.stack;
    }

    public Map<String, Double> getMap()
    {
        return this.variableMap;
    }
}
