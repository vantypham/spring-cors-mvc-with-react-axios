import React, {useEffect, useState, useRef} from 'react';
import axios from 'axios';

interface Greeting {
  id: number;
  content: string;
}

function App() {
  const emptyGreeting = {id: -1, content: ''};
  const [greet, setGreet] = useState<Greeting>(emptyGreeting);

  useEffect(() => {
    //loadGreeting
    const username = 'user';
    const password = '5daf5198-dc1d-4cf5-af70-6760c0d013ce';
    const authorization = 'Basic ' + btoa(username + ':' + password);
    const greeting = async () => {
        const res = await axios.get("http://localhost:8080/greeting-javaconfig", {
          headers: {
            'Content-Type': 'application/json',
            'Authorization': authorization
          }
        });
        if (res.status === 200) {
            setGreet(res.data);
        } else {
          console.log("Error !");
        }
    }
    //call loadGreeting endpoint
    greeting();
  }, []);

  return (
    <div className="App">
      <p>{greet.id}</p>
      <p>{greet.content}</p>
    </div>
  );
}

export default App;
