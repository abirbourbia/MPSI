import Button from './Button'
const Header = (props) => {

  const onClick = () => {
    console.log("click")
}

  return (
    <header className="header">
    <h1>{props.title}</h1>
    <Button text='Add' onClick={onClick}></Button>
    </header>
  )
}

Header.defaultProps = {
  title:'Task Tracker',
}
export default Header
