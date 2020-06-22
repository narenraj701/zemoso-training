import React from 'react';

const style={
    color:'white',
    backgroundColor:'#ffa500',
    borderRadius:'5px',
    border: 'none',
    fontSize: '15px',
    padding: '10px',
    width: '150px',
    cursor: 'pointer',
    margin:'3px',
    fontStyle:'bold',
    fontWeight:'900'
};

const Option=props=><button style={style} onClick={props.clicked}>{props.option}</button>;

export default Option;