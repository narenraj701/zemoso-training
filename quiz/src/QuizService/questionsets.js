const questionsets = [
    {
        question: "Telangana state formation day ?",
        options: ['01 August', '02 June', '10 September'],
        correct: '02 June',
        id: 1
    },
    {
        question: "Who is the Chief minister of Telangana?",
        options: ['KTR', 'KCR', 'CBN'],
        correct: 'KCR',
        id: 2
    },
    {
        question: "Who is the Director of Baahubali?",
        options: ['Trivikram', 'Krishnavamshi', 'Rajamouli'],
        correct: 'Rajamouli',
        id: 3
    },
    {
        question: "Who Won 2019 Cricket World Cup?",
        options: ['India', 'England', 'Australia'],
        correct: 'England',
        id: 4
    },
    {
        question: "What is Tasmania?",
        options: ["An Australian State", "A flavor of Ben and Jerry's ice-cream", "A Psychological Disorder"],
        correct: "An Australian State",
        id: 5
    },
    {
        question: "What company developed the vocaloid Hatsune Miku?",
        options: ["Crypton Future Media", "Sony", "Yamaha Corporation"],
        correct: "Crypton Future Media",
        id: 6
    },
    {
        question:
            "Which country, not including Japan, has the most people of japanese decent?",
        options: ["Brazil", "China", "United States of America"],
        correct: "Brazil",
        id: 7
    },
    {
        question: "Which candy is NOT made by Mars?",
        options: ["Almond Joy", "Twix", "Snickers"],
        correct: "Almond Joy",
        id: 8
    },
    {
        question: "In which fast food chain can you order a Jamocha Shake?",
        options: ["Arby's", "McDonald's", "Burger King"],
        correct: "Arby's",
        id: 9
    }

]

export default (n = 4) =>
    Promise.resolve(questionsets.sort(() => 0.4 - Math.random()).slice(0, n));