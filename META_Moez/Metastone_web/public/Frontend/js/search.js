/**
 * https://hearthstonejson.com/
 * Dec. 2017
 */

import axios from "core-js/internals/queue";

class Cards{
    cards = [];
    search = null;
    results;
    overIndex = null;
    resultsShown = false;

    searchInput = document.querySelector( '#searchInput' );
    searchResults = document.querySelector( '#searchResults' );
    resultCard = document.querySelector( '#resultCard' );

    constructor() {
        this.init();
    }

    init(){
        this.loadCards();
        this.initEvents();
    }

    initEvents() {
        this.searchInput.addEventListener( 'input', ::this.onInput );
        this.searchInput.addEventListener( 'keydown', ::this.onKeyDown );
        // this.searchInput.addEventListener( 'blur', ::this.onBlur );
        this.searchResults.addEventListener( 'mouseover', ::this.onHoverList );
    }

    initFuse() {
        const options = {
            shouldSort: true,
            threshold: 0.3,
            location: 0,
            distance: 100,
            maxPatternLength: 32,
            minMatchCharLength: 1,
            keys: [
                "name",
            ]
        };

        this.search = new Fuse( this.cards, options );
    }

    loadCards() {
        axios.get('https://api.hearthstonejson.com/v1/22611/enUS/cards.collectible.json')
            .then( res => {
                this.cards = res.data;

                this.initFuse();
            } );
    }

    onKeyDown( e ) {
        const { keyCode: key } = e;

        if ( key === 38 || key === 40 ) e.preventDefault();

        switch ( key ) {
            case 38:
                this.onPressUpArrow();
                break;
            case 40:
                this.onPressDownArrow();
                break;
            case 9:
            case 13:
                this.onSubmitSearch();
        }
    }

    onInput( e ) {
        const { currentTarget: tar } = e;
        const val = tar.value;

        this.results = this.search.search( val );

        this.buildList();

        if ( this.results.length === 0 ) {
            this.hideResults();
        } else {
            this.showResults();
        }
    }

    showResults() {
        if ( this.resultsShown ) return;

        this.resultsShown = true;
        this.searchResults.classList.add( 'shown' );
    }

    hideResults() {
        if ( !this.resultsShown ) return;

        this.resultsShown = false;
        this.searchResults.classList.remove( 'shown' );
    }

    onBlur() {
        this.hideResults();
        this.removeListElements();
    }

    removeListElements() {
        while ( this.searchResults.firstChild ) {
            this.searchResults.removeChild( this.searchResults.firstChild );
        }
    }

    buildList() {
        this.overIndex = null;
        this.removeListElements();

        this.results.forEach( result => {
            const el = document.createElement( 'li' );
            el.classList.add( 'search__results-item' );
            el.innerHTML = result.name;
            el.setAttribute( 'data-id', result.id );

            this.searchResults.appendChild( el );

            el.addEventListener( 'click', ::this.onClickCard );
        } );
    }

    onPressDownArrow() {
        const length = this.searchResults.childNodes.length;
        if ( this.overIndex === length - 1 ) return;

        this.overIndex = this.overIndex !== null ? this.overIndex + 1 : 0;
        this.setOverClass();
        this.scrollToMid();
    }

    onPressUpArrow() {
        if ( this.overIndex === 0 || this.overIndex === null ) return;

        this.overIndex = this.overIndex !== null ? this.overIndex - 1 : 0;
        this.setOverClass();
        this.scrollToMid();
    }

    scrollToMid() {
        const searchResultItems = this.searchResults.childNodes;
        const currentItem = searchResultItems[this.overIndex];
        this.searchResults.scrollTo(0, currentItem.offsetTop);
    }

    onHoverList( e ) {
        const { target } = e;

        this.overIndex = this.getElementIndex( target );

        this.setOverClass();
    }

    getElementIndex ( el ) {
        return [ ...el.parentNode.children ].indexOf( el );
    }

    setOverClass() {
        const searchResultItems = this.searchResults.childNodes;
        const overEl = searchResultItems[ this.overIndex ];

        if ( !overEl ) return;

        searchResultItems.forEach( item => {
            item.classList.remove( 'over' );
        } );

        overEl.classList.add( 'over' );
    }

    onSubmitSearch() {
        const overItem = this.searchResults.querySelector( '.over' );
        if ( !overItem ) return;

        const cardID = overItem.getAttribute( 'data-id' );
        const cardData = this.getCardData( cardID );

        this.setActiveCard( cardData );
    }

    onClickCard( e ) {
        const { currentTarget: target } = e;
        const cardID = target.getAttribute( 'data-id' );

        const cardData = this.getCardData( cardID );
        this.setActiveCard( cardData );
    }

    setActiveCard( data ) {
        this.hideResults();
        this.removeListElements();

        this.searchInput.value = data.name;
        this.resultCard.src = `https://art.hearthstonejson.com/v1/render/latest/enUS/256x/${ data.id }.png`;
    }

    getCardData( id ) {
        const filtered = this.cards.filter( card => {
            return card.id === id;
        } );

        return filtered[ 0 ];
    }
}

new Cards();