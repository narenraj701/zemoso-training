import React from 'react';
import Header from '../Atoms/Header';
import QuestionBox from '../Molecules/QuestionBox';
import questionset from '../../QuizService/questionsets';
import Results from '../Molecules/Results';
import '../../index.css';

class TableComponent extends React.Component{
    state={
        sets:[],
        score:0,
        responses:0
        };
    getQuestions=()=>{
        questionset().then(question=>{
            this.setState({
                sets:question
            });
        });
    };
    componentDidMount(){
        this.getQuestions();
    }
    computeAnswer=(answer,correct)=>{
        if(answer===correct){
            this.setState({
                score:this.state.score+1
            });
        }
        this.setState({
            responses:this.state.responses<4 ? this.state.responses+1 : 4
        })
    };
    reset=()=>{
    this.setState({score:0,responses:0})
    this.getQuestions();
    }
render(){ 

    return  <div className='maintable'>
                <Header header={this.props.header} />
                {
                this.state.responses<4 &&
                this.state.sets.map(questionset=>(
                    <QuestionBox 
                    question={questionset.question} 
                    options={questionset.options} 
                    key={questionset.id}
                    selected={ans=>this.computeAnswer(ans,questionset.correct)}
                    />
                ))}
                {this.state.responses===4?<Results score={this.state.score} playAgain={this.reset}/> : null}
            </div> 
    };
}

export default TableComponent;