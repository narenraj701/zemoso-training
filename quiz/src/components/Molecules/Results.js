import React from 'react';

const Results=(props)=>{
    const messages=["Excellent !!!","Good Work !","Better Luck Next Time :("];
    const style={
        backgroundColor: '#4CAF50',
        border: 'none',
        borderRadius:'5px',
        fontSize: '25px',
        color: '#FFFFFF',
        padding: '10px',
        width: '150px',
        textAlign: 'center',
        cursor:'pointer'
    };
    let suggestion="";
    if(props.score===0 || props.score===1 || props.score===2){
        suggestion=messages[2];
    }
    else if(props.score===3){
        suggestion=messages[1]
    }
    else{
        suggestion=messages[0];
    }
    return (
    <div>
        <h1>Your Score is {props.score}/4</h1>
        <h2>{suggestion}</h2>
        <button style={style} onClick={props.playAgain}>PlayAgain</button>
    </div>
    );
}

export default Results; 