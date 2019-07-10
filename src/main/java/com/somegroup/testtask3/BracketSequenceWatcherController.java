package com.somegroup.testtask3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Stack;

@RestController
public class BracketSequenceWatcherController {

    @RequestMapping(value = "/watcher", method = { RequestMethod.GET, RequestMethod.POST })
    public BracketSequenceWatcher watcher(@RequestParam(value="query", defaultValue="") String name) {
        return new BracketSequenceWatcher(name, checkIfNormalized(name));
    }

    public boolean checkIfNormalized(String sequence){ //this method checks whether bracket sequence is regular or not using Stack
        Stack<String> q = new Stack<>();

        for (int i = 0; i < sequence.length(); i++)
        {
            String oneSymbol = sequence.substring(i, i + 1);

            if (oneSymbol.equals("(") || oneSymbol.equals("{") || oneSymbol.equals("[")) {
                q.push(oneSymbol);
            }
            else if(oneSymbol.equals(")")) {
                if(q.empty() || !q.peek().equals("("))
                    return false;
                else q.pop();
            }
            else if(oneSymbol.equals("}")) {
                if(q.empty() || !q.peek().equals("{"))
                    return false;
                else q.pop();
            }
            else if(oneSymbol.equals("]")) {
                if(q.empty() || !q.peek().equals("["))
                    return false;
                else q.pop();
            }
        }

        return q.empty() ;
    }
}