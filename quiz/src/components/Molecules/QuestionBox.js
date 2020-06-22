import React, { useState } from 'react';
import Button from '../Atoms/Option';
import Question from '../Atoms/Question';
import '../../index.css'
const QuestionBox=props=>{
    const [answer,setAnswer]=useState(props.options);
    return (
    <div className='qbox'>
        <Question question={props.question} />
        {answer.map((val,index)=>(
            <Button key={index} option={val} clicked={()=>{
                setAnswer([val]);
                props.selected(val);
            }} />
        ))}
    </div>
    );
}

export default QuestionBox;