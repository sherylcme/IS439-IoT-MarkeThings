import React from 'react';
import axios from 'axios';
import history from './history';

const textBoxStyle = {
        width:"80vw",
        height:"5vh",
        fontSize:"3vh",
        fontFamily:"Helvetica" 
}

const labelStyle = {
    fontSize:30,
    fontFamily:"Helvetica" 
}

const buttonStyle = {
    /* default for <button>, but useful for <a> */
    color: "black",
    border: "0 none",
    borderRadius: "4px",
    margin: "10px",
    padding: "12px 12px",
    fontSize: "20px",
    fontWeight: 500,
    lineHeight: 1.3
 
}

export class Home extends React.Component {

   
    constructor() {
        super();
        this.state = {
            data: [],
            age: '',
            genderArr:["Male","Female"],
            gender: '',
            code: '',
            campaign: ["Content Management", "Affiliate Management", "Search Engine Optimization", "Campaign Management"],
            categoryArr: ["$5 Entertainment", "$5 Food", "$5 Household", "$5 Beauty & Wellness", "$5 Technology", "$5 Fashion"],
            region:["North","South","East","West"],
            category:'Food',
            date: new Date()
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) { //General handler bracket target the key of our state object.. obj['key']
        this.setState({ [event.target.name]: event.target.value });
    }

    handleSubmit(event) {
        try {
            alert('Your voucher will be displayed in your wallet.');
            //do post request - store the variable and post below.

            const user = {
                age: Math.floor(Math.random() * (70 - 15)) + 15,
                gender: this.state.genderArr[Math.floor(Math.random() * (2 - 0)) + 0],
                code: this.state.code,
                time: this.state.date.toLocaleDateString() + " " + this.state.date.toLocaleTimeString(),
                campaign: this.state.campaign[Math.floor(Math.random() * (4 - 0)) + 0],
                category: this.state.category,
                region: this.state.region[Math.floor(Math.random() * (4 - 0)) + 0],
                voucher: Math.floor(Math.random() * (10 - 0)) + 0,
                status: 'New'
            }
            axios.post("http://206.189.153.61:8080/is439/", user)
                .then(response => console.log(response))
                .then(this.props.history.push("/success"));
            event.preventDefault();
        } catch (error) {
            console.error(error);
        }
    }

    render() {

        return (
            <div className="pet-form">
                <form onSubmit={this.handleSubmit}>
                    <h3 style={{padding:10}}>Please enter the marketing code to begin your redemption.</h3>
                
                    <label style={labelStyle}>Code</label>
                    <br />
                    <input type="text" name="code" onChange={this.handleChange} style={textBoxStyle}></input>
                    <br /><br />

                    <label style={labelStyle}>Select Voucher</label>
                    <br/>
                    <select value={this.state.category} name="category" onChange={this.handleChange} style={textBoxStyle}>
                        {this.state.categoryArr.map(val =>{
                            return <option value={val}>{val}</option>  
                        })};
                    </select>
                    <br/><br/>
                    <input type="submit" value="Submit" style = {buttonStyle}></input>
                </form>
            </div>
        );
    }
}
